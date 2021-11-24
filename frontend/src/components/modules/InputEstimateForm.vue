<template>
<dev>
    <span>
        <label for="estimate_id">見積番号</label>
        <input v-model="estimateId" type="text" id="estimate_id"/>
    </span>
    <br>
    <span>
        <label for="estimate_name">見積案件名</label>
        <input v-model="estimateName" type="text" id="estimate_name"/>
    </span>
    <span>
        <label for="status">見積ステータス</label>
        <input v-model="status" type="text" id="status"/>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-model="customerName" type="text" id="customer_name"/>
    </span>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-model="employeeName" type="text" id="employee_name"/>
    </span>
    <br>
    <span>
        <label for="budgeted_amount">予算金額</label>
        <input v-model="budgetedAmount" type="text" id="budgeted_amount"/>
    </span>
    <span>
        <label for="estimate_amount">予算超過額</label>
        <input v-model="estimateAmount" type="text" id="estimate_amount"/>
    </span>
    <br>
    <span>
        <label for="total_price">合計</label>
        <input v-model="totalPrice" type="text" id="total_price"/>
    </span>
</dev>
</template>

<script>

</script>

<style>

</style>