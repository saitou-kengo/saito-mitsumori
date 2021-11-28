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
        <div v-for="estimate in estimates" :key="estimate.id">
        <tr>
            <td>{{ estimate.id }}</td>
            <td>{{ estimate.estimateName }}</td>
            <td>{{ estimate.status }}</td>
            <td>{{ estimate.customerName }}</td>
            <td>{{ estimate.employeeName }}</td>
            <td>{{ estimate.budgetedAmount }}</td>
            <td>{{ estimate.amount }}</td>
            <td><router-link :to="{ name:'detail',params:{ id : estimate.id }}">詳細</router-link></td>
            <td><router-link :to="{ name:'edit',params:{ id : estimate.id }}">編集</router-link></td>
        </tr>
        </div>
    </table>
</div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            estimates: null
        };
    },
    methods: {
        getEstimatesList() {
        axios
        .get('http://localhost:8080/api/v1/estimates')
        .then(res => {
            this.estimates = res.data;
            console.log("retrieve all Estimate");
        })
        .catch(err => {
            console.log('エラー：' + err);
        });
        }
    },
    created: function() {
        this.getEstimatesList();
    }
}

</script>

<style>
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