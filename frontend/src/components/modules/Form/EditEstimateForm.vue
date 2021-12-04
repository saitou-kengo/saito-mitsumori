<template>
<div class="container">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積番号</span>
        </div>
        <input v-if="estimate" v-model="estimate.id" type="text" id="estimate_id" disabled="disabled"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積案件名</span>
        </div>
        <input v-if="estimate" v-model="estimate.estimateName" type="text" id="estimate_name" placeholder="入力してください"/>
        <div class="input-group-prepend">
            <span class="input-group-text">見積ステータス</span>
        </div>
        <input v-if="estimate" v-model="estimate.status" type="text" id="status" disabled="disabled"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">顧客名</span>
        </div>
        <input v-if="estimate" v-model="estimate.customerName" type="text" id="customer_name" disabled="disabled" placeholder="選択してください"/>
        <button @click="showCustomerSearchDialog" class="btn btn-primary" id="button">顧客検索</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='customerName = $event'
        />
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名</span>
        </div>
        <input v-if="estimate" v-model="estimate.employeeName" type="text" id="employee_name" disabled="disabled" placeholder="選択してください"/>
        <button @click="showEmployeeSearchDialog" class="btn btn-primary" id="button">担当者検索</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='employeeName = $event'
        />
    </div>
    <br>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">予算金額</span>
        </div>
        <input v-if="estimate" v-model="estimate.amount" type="text" id="amount" placeholder="入力してください"/>
        <div class="input-group-prepend">
            <span class="input-group-text">予算超過額</span>
        </div>
        <input v-if="estimate" v-model="overAmount" type="text" id="over_amount" disabled="disabled"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">合計</span>
        </div>
        <input v-if="estimate" v-model="estimate.budgetedAmount" type="text" id="budgeted_amount" disabled="disabled"/>
    </div>
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
