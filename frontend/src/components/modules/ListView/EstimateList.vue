<template>
<div>
    <span id="index">検索結果一覧</span>
    <br>
    <table class="table table-bordered" style="width: 90%">
        <thead class="thead-lignt">
        <tr>
            <th id="estimate-id">見積番号</th>
            <th id="estimate-name">案件名</th>
            <th id="status">ステータス</th>
            <th id="customer-name">顧客名</th>
            <th id="employee-name">担当者名</th>
            <th id="amount">予算金額</th>
            <th id="budgeted-amount">見積金額</th>
            <th id="detail">詳細</th>
            <th id="edit">編集</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="estimate in estimates" :key="estimate.id">
            <td id="estimate-id">{{ estimate.id }}</td>
            <td id="estimate-name">{{ estimate.estimateName }}</td>
            <td id="status">{{ estimate.status }}</td>
            <td id="customer-name">{{ estimate.customerName }}</td>
            <td id="employee-name">{{ estimate.employeeName }}</td>
            <td id="amount">{{ estimate.budgetedAmount }}</td>
            <td id="budgeted-amount">{{ estimate.amount }}</td>
            <td id="detail"><router-link :to="{ name:'detail',params:{ id : estimate.id }}">詳細</router-link></td>
            <td id="edit"><router-link :to="{ name:'edit',params:{ id : estimate.id }}">編集</router-link></td>
        </tr>
        </tbody>
    </table>
</div>
</template>

<script>

export default {
    props: ['estimates']
}

</script>
