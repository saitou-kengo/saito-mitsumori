<template>
<div class="container">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積番号</span>
        </div>
        <input type="text" id="estimate_id" disabled="disabled" :value="id"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積案件名</span>
        </div>
        <input v-if="estimate" type="text" id="estimate_name" disabled="disabled" :value="estimate.estimateName"/>
        <div class="input-group-prepend">
            <span class="input-group-text">見積ステータス</span>
        </div>
        <input v-if="estimate" type="text" id="status" disabled="disabled" :value="estimate.status"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">顧客名</span>
        </div>
        <input v-if="estimate" type="text" id="customer_name" disabled="disabled" :value="estimate.customerName"/>
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名</span>
        </div>
        <input v-if="estimate" type="text" id="employee_name" disabled="disabled" :value="estimate.employeeName"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">予算金額</span>
        </div>
        <input v-if="estimate" type="text" id="amount" disabled="disabled" :value="estimate.amount"/>
        <div class="input-group-prepend">
            <span class="input-group-text">予算超過額</span>
        </div>
        <input v-if="overAmount" type="text" id="over_amount" disabled="disabled" :value="overAmount"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">合計</span>
        </div>
        <input v-if="estimate" type="text" id="budgeted_amount" disabled="disabled" :value="estimate.budgetedAmount"/>
    </div>
</div>
</template>

<script>
export default {
    props: ['id', 'estimate', 'overAmount']
}
</script>

<style>

</style>