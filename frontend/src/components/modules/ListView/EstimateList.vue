<template>
<div>
    <span id="index">検索結果一覧</span>
    <br>
    <table class="table table-bordered" style="width: 90%">
        <thead class="thead-lignt">
        <tr>
            <th id="estimateId">見積番号</th>
            <th id="estimateName">案件名</th>
            <th id="status">ステータス</th>
            <th id="customerName">顧客名</th>
            <th id="employeeName">担当者名</th>
            <th id="amount">予算金額</th>
            <th id="budgetedAmount">見積金額</th>
            <th id="detail">詳細</th>
            <th id="edit">編集</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="estimate in estimates" :key="estimate.id">
            <td id="estimateId">{{ estimate.id }}</td>
            <td id="estimateName">{{ estimate.estimateName }}</td>
            <td id="status">{{ estimate.status }}</td>
            <td id="customerName">{{ estimate.customerName }}</td>
            <td id="employeeName">{{ estimate.employeeName }}</td>
            <td id="amount">{{ estimate.budgetedAmount }}</td>
            <td id="budgetedAmount">{{ estimate.amount }}</td>
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

<style>
table {
    margin: auto;
}

#estimateId {
    width: 5%;
}

#estimateName {
    width: 20%;
}

#status {
    width: 10%;
}

#customerName {
    width: 15%;
}

#employeeName {
    width: 15%;
}

#amount {
    width: 10%;
}

#budgetedAmount {
    width: 10%;
}

#detail {
    width: 5%;
    text-align: center;
}

#edit {
    width: 5%;
    text-align: center;
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