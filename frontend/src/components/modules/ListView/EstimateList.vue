<template>
<div>
    <span id="index">検索結果一覧</span>
    <br>
    <table>
        <tr>
            <th>見積番号</th>
            <th>案件名</th>
            <th>ステータス</th>
            <th>顧客名</th>
            <th>担当者名</th>
            <th>予算金額</th>
            <th>見積金額</th>
            <th>詳細</th>
            <th>編集</th>
        </tr>
        <tr>
        <div v-for="estimate in estimates" :key="estimate.id">
            <td>{{ estimate.id }}</td>
            <td>{{ estimate.estimateName }}</td>
            <td>{{ estimate.status }}</td>
            <td>{{ estimate.customerName }}</td>
            <td>{{ estimate.employeeName }}</td>
            <td>{{ estimate.budgetedAmount }}</td>
            <td>{{ estimate.amount }}</td>
            <td><router-link :to="{ name:'detail',params:{ id : estimate.id }}">詳細</router-link></td>
            <td><router-link :to="{ name:'edit',params:{ id : estimate.id }}">編集</router-link></td>
        </div>
        </tr>
    </table>
</div>
</template>

<script>

export default {
    props: ['estimates']
}

</script>

<style>
table {
    table-layout:fixed;
    width: 80%;
    border-collapse:  collapse;
}

th,td {
    border: solid 1px;
}

#index {
    display: flex;
    align-items: center;
    justify-content: center;
}

#index:before, .catch:after {
    border-top: 1px solid;
    content: "";
    width: 3em;
}

#index:before {
    margin-right: 1em;
}

#index:after {
    margin-left: 1em;
}
</style>