<template>
<div class="container">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積番号</span>
        </div>
        <input type="text" id="estimate_id" disabled="disabled" placeholder="自動採番"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積案件名</span>
        </div>
        <input type="text" v-model="estimate.estimateName" id="estimate_name" placeholder="入力してください"/>
        <div class="input-group-prepend">
            <span class="input-group-text">見積ステータス</span>
        </div>
        <select v-model="estimate.status" id="status" placeholder="選択してください">
            <option>1:見積中</option>
            <option>2:見積完了</option>
            <option>3:受注済</option>
        </select>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">顧客名</span>
        </div>
        <input v-model="estimate.customer.name" type="text" id="customer_name" disabled="disabled" placeholder="顧客名を選択してください"/>
        <button @click="showCustomerSearchDialog" class="btn btn-primary">顧客検索</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='selectCustomer'
        />
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名</span>
        </div>
        <input v-model="estimate.employee.name" type="text" id="employee_name" disabled="disabled" placeholder="担当者名を選択してください"/>
        <button @click="showEmployeeSearchDialog" class="btn btn-primary">担当者検索</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='selectEmployee'
        />
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">予算金額</span>
        </div>
        <input v-model="estimate.amount" type="text" id="amount" placeholder="入力してください"/>
        <label for="over_amount">予算超過額</label>
        <input v-model="overAmount" type="text" id="over_amount" disabled="disabled"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">合計</span>
        </div>
        <input v-model="totalPrice" type="text" id="budgeted_amount" disabled="disabled"/>
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
                status: null,
                customer: {
                    cd: null,
                    name: null
                },
                employee: {
                    cd: null,
                    name: null
                },
                budgetedAmount: null,
                amount: null
            }
        }
    },
    computed: {
    overAmount: function() {
        return (this.estimate.amount >= 0 ? this.totalPrice - this.estimate.amount : "-");
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

<style>

</style>