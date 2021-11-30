<template>
<div>
    <span>
        <label for="estimate_id">見積番号</label>
        <input type="text" id="estimate_id" disabled="disabled" :value="id"/>
    </span>
    <br>
    <span>
        <label for="estimate_name">見積案件名</label>
        <input v-if="estimate" type="text" id="estimate_name" disabled="disabled" :value="estimate.estimateName"/>
    </span>
    <span>
        <label for="status">見積ステータス</label>
        <input v-if="estimate" type="text" id="status" disabled="disabled" :value="estimate.status"/>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-if="estimate" type="text" id="customer_name" disabled="disabled" :value="estimate.customerName"/>
    </span>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-if="estimate" type="text" id="employee_name" disabled="disabled" :value="estimate.employeeName"/>
    </span>
    <br>
    <span>
        <label for="amount">予算金額</label>
        <input v-if="estimate" type="text" id="amount" disabled="disabled" :value="estimate.amount"/>
    </span>
    <span>
        <label for="over_amount">予算超過額</label>
        <input v-if="overAmount" type="text" id="over_amount" disabled="disabled" :value="overAmount"/>
    </span>
    <br>
    <span>
        <label for="budgeted_amount">合計</label>
        <input v-if="estimate" type="text" id="budgeted_amount" disabled="disabled" :value="estimate.budgetedAmount"/>
    </span>
</div>
</template>

<script>
export default {
    props: ['id', 'estimate', 'overAmount']
}
</script>

<style>

</style>