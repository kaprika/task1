import { LightningElement, api, track } from 'lwc';
import findRecords from '@salesforce/apex/SearchController.findRecords';
const DELAY = 200;

export default class ObjectLookup extends LightningElement {
    @api objectName;
    @track objectList = [];
    @api labelName;
    @api placeholder = 'Search...';
    @api fields;
    @api whereConditions;
    @api orderByAsc;
    @api orderByDesc;
    @api limitCondition;
    searchKey = '';
    selectedRecord;
    recordId;
    showSearchedRecords = false;

    get showResultMessage() {
        return (this.objectList.length == 0 && this.searchKey.length > 1)
    }

    handleKeyChange(event) {
        this.searchKey = event.target.value;
        window.clearTimeout(this.delayTimeout);
        this.delayTimeout = setTimeout(() => {
            if (this.searchKey.length >= 2) {
                findRecords({
                    objectApiName: this.objectName,
                    fields: this.fields,
                    searchKey: this.searchKey,
                    whereConditions: this.whereConditions,
                    orderByAsc: this.orderByAsc,
                    orderByDesc: this.orderByDesc,
                    limitCondition: this.limitCondition
                })
                    .then(result => {
                        let stringResult = JSON.stringify(result);
                        let allResult = JSON.parse(stringResult);
                        allResult.forEach(record => {
                            record.field1 = record[this.fields[0]];
                            if (this.fields[1]) {
                                record.field2 = record[this.fields[1]];
                            }
                            else {
                                record.field2 = '';
                            }
                            if (this.fields[2]) {
                                record.field3 = record[this.fields[2]];
                            } else {
                                record.field3 = '';
                            }
                        });
                        this.objectList = allResult;
                        this.showSearchedRecords = (this.objectList.length != 0);
                        console.log('data : ' + this.objectList.length);
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    })
                    .finally(() => {
                    });
            }
            else {
                this.showSearchedRecords = false;
            }
        }, DELAY);
    }

    handleSelect(event) {
        this.showSearchedRecords = false;
        this.recordId = event.target.dataset.recordId;
        this.selectedRecord = this.objectList.find((item) => {
            return item.Id === this.recordId;
        });
        this.searchKey = this.selectedRecord[this.fields[0]];
        const selectedEvent = new CustomEvent('selected', { detail: this.recordId });
        this.dispatchEvent(selectedEvent);
    }
}