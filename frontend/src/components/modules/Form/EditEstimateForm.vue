<template>
<div>
    <span>
        <label for="estimate_id">見積番号</label>
        <input v-if="estimate" v-model="estimate.id" type="text" id="estimate_id" disabled="disabled"/>
    </span>
    <br>
    <span>
        <label for="estimate_name">見積案件名</label>
        <input v-if="estimate" v-model="estimate.estimateName" type="text" id="estimate_name"/>
    </span>
    <span>
        <label for="status">見積ステータス</label>
        <input v-if="estimate" v-model="estimate.status" type="text" id="status" disabled="disabled"/>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-if="estimate" v-model="estimate.customerName" type="text" id="customer_name" disabled="disabled"/>
        <button @click="showCustomerSearchDialog">顧客検索</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='customerName = $event'
        />
    </span>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-if="estimate" v-model="estimate.employeeName" type="text" id="employee_name" disabled="disabled"/>
        <button @click="showEmployeeSearchDialog">担当者選択</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='employeeName = $event'
        />
    </span>
    <br>
    <span>
        <label for="amount">予算金額</label>
        <input v-if="estimate" v-model="estimate.amount" type="text" id="amount"/>
    </span>
    <span>
        <label for="over_amount">予算超過額</label>
        <input v-if="estimate" v-model="overAmount" type="text" id="over_amount" disabled="disabled"/>
    </span>
    <br>
    <span>
        <label for="budgeted_amount">合計</label>
        <input v-if="estimate" v-model="estimate.budgetedAmount" type="text" id="budgeted_amount" disabled="disabled"/>
    </span>
</div>
</template>

<script>
import CustomerSearchDialog from '../Dialog/CustomerSearchDialog.vue'
import EmployeeSearchDialog from '../Dialog/EmployeeSearchDialog.vue'

export default {
    props: ['estimate'],
    components: {
        CustomerSearchDialog,
        EmployeeSearchDialog
    },
    data() {
        return {
            estimateId: null,
            estimateName: null,
            status: null,
            customerName: null,
            employeeName: null,
            amount: null,
            budgetedAmount: null
        }
    },
    computed: {
    overAmount: function() {
        return this.estimate.budgetedAmount - this.estimate.amount;
    }
    },
    methods: {
        showCustomerSearchDialog: function() {
            this.$refs.cDialog.showDialog();
        },
        showEmployeeSearchDialog: function() {
            this.$refs.eDialog.showDialog();
        }
    }
}
</script>

<style>

</style>