<template>
<div>
    <span>
        <label for="estimate_id">見積番号</label>
        <input type="text" id="estimate_id" disabled="disabled" value="自動採番"/>
    </span>
    <br>
    <span>
        <label for="estimate_name">見積案件名</label>
        <input type="text" v-model="estimate.estimateName" id="estimate_name"/>
    </span>
    <span>
        <label for="status">見積ステータス</label>
        <select v-model="estimate.status" id="status">
            <option>1:見積中</option>
            <option>2:見積完了</option>
            <option>3:受注済</option>
        </select>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-model="estimate.customerName" type="text" id="customer_name" disabled="disabled"/>
        <button @click="showCustomerSearchDialog">顧客検索</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='estimate.customerName = $event'
        />
    </span>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-model="estimate.employeeName" type="text" id="employee_name" disabled="disabled"/>
        <button @click="showEmployeeSearchDialog">担当者選択</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='estimate.employeeName = $event'
        />
    </span>
    <br>
    <span>
        <label for="amount">予算金額</label>
        <input v-model="estimate.amount" type="text" id="amount"/>
    </span>
    <span>
        <label for="over_amount">予算超過額</label>
        <input v-model="overAmount" type="text" id="over_amount" disabled="disabled"/>
    </span>
    <br>
    <span>
        <label for="budgeted_amount">合計</label>
        <input v-model="estimate.budgetedAmount" type="text" id="budgeted_amount"/>
    </span>
</div>
</template>

<script>
import CustomerSearchDialog from '../Dialog/CustomerSearchDialog.vue'
import EmployeeSearchDialog from '../Dialog/EmployeeSearchDialog.vue'

export default {
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
                customerName: "顧客を選択してください",
                employeeName: "担当者を選択してください",
                budgetedAmount: null,
                amount: "予算金額入力してください",
            }
        }
    },
    computed: {
    overAmount: function() {
        return (this.estimate.amount >= 0 ? this.estimate.budgetedAmount - this.estimate.amount : "-");
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