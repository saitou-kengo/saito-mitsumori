<template>
<div class="container">
    <div class="row margin-15">
        <div class="col">
            <span class="page-title">
                見積登録
            </span>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-calendar-plus-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM8.5 8.5V10H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V11H6a.5.5 0 0 1 0-1h1.5V8.5a.5.5 0 0 1 1 0z"/>
                        </svg>
                        見積番号
                    </span>
                </div>
                <input type="text" class="col-md-4" id="estimate_id" disabled="disabled" placeholder="自動採番"/>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-calendar-plus-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM8.5 8.5V10H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V11H6a.5.5 0 0 1 0-1h1.5V8.5a.5.5 0 0 1 1 0z"/>
                        </svg>
                        見積案件名
                    </span>
                </div>
                <input type="text" v-model="estimate.estimateName" class="col-md-4" id="estimate_name" placeholder="入力してください"/>
                <div class="offset-1"></div>
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-calendar-plus-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM8.5 8.5V10H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V11H6a.5.5 0 0 1 0-1h1.5V8.5a.5.5 0 0 1 1 0z"/>
                        </svg>
                        見積ステータス
                    </span>
                </div>
                <select v-model="estimate.status" class="col-md-4" id="status">
                    <option disabled="disabled">ステータスを選択してください</option>
                    <option>1:見積中</option>
                    <option>2:見積完了</option>
                    <option>3:受注済</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        顧客名
                    </span>
                </div>
                <input v-model="estimate.customer.name" type="text" class="col-md-3" id="customer_name" disabled="disabled" placeholder="顧客名を選択してください"/>
                <button @click="showCustomerSearchDialog" class="btn btn-primary" id="button">顧客検索</button>
                <customer-search-dialog ref="cDialog"
                    @select-customer='selectCustomer'
                />
                <div class="offset-1"></div>
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        担当者名
                    </span>
                </div>
                <input v-model="estimate.employee.name" type="text" class="col-md-3" id="employee_name" disabled="disabled" placeholder="担当者名を選択してください"/>
                <button @click="showEmployeeSearchDialog" class="btn btn-primary" id="button">担当者検索</button>
                <employee-search-dialog ref="eDialog"
                    @select-employee='selectEmployee'
                />
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        予算金額
                    </span>
                </div>
                <input v-model="estimate.amount" type="text" class="col-md-4" id="amount" placeholder="入力してください"/>
                <div class="offset-1"></div>
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        予算超過額
                    </span>
                </div>
                <input v-model="overAmount" type="text" class="col-md-4" id="over_amount" disabled="disabled"/>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        合計
                    </span>
                </div>
                <input v-model="totalPrice" type="text" class="col-md-4" id="budgeted_amount" disabled="disabled"/>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import CustomerSearchDialog from '../Dialog/CustomerSearchDialog.vue'
import EmployeeSearchDialog from '../Dialog/EmployeeSearchDialog.vue'

export default {
    props: ['totalPrice'],
    components: {
        CustomerSearchDialog,
        EmployeeSearchDialog
    },
    data() {
        return {
            estimateId: null,
            estimate: {
                estimateName: null,
                status: 'ステータスを選択してください',
                customer: {
                    cd: null,
                    name: null
                },
                employee: {
                    cd: null,
                    name: null
                },
                amount: null
            }
        }
    },
    computed: {
        overAmount: function() {
            return (this.estimate.amount != null ? this.totalPrice - this.estimate.amount : '-');
        }
    },
    methods: {
        showCustomerSearchDialog: function() {
            this.$refs.cDialog.showDialog();
        },
        showEmployeeSearchDialog: function() {
            this.$refs.eDialog.showDialog();
        },
        selectCustomer: function(customerCd, customerName) {
            this.estimate.customer.cd = customerCd;
            this.estimate.customer.name = customerName;
        },
        selectEmployee: function(employeeCd, employeeName) {
            this.estimate.employee.cd = employeeCd;
            this.estimate.employee.name = employeeName;            
        }
    },
    watch: {
        estimate: {
            handler() {
                this.$emit('init-estimate', this.estimate);
            },
            deep: true
        }
    }
}
</script>
