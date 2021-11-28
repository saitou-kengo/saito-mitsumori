<template>
<div>
    <span id="index">見積明細</span>
    <br>
    <table>
        <tr>
            <th>枝番</th>
            <th>商品名</th>
            <th>単価</th>
            <th>数量</th>
            <th>金額</th>
            <th>削除</th>
        </tr>
        <div v-for="detail in details" :key="detail.id">
        <tr>
            <td>{{ detail.id }}</td>
            <td>{{ detail.productName }}</td>
            <td>{{ detail.price }}</td>
            <td>{{ detail.quantity }}</td>
            <td>{{ detail.totalPrice }}</td>
            <td>削除</td>
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
            details: null
        }
    },
    methods: {
    getEstimateDetailsListById() {
    axios
    .get('http://localhost:8080/api/v1/estimate-details/', {
        params: {
        id: 1
        }
    })
    .then(res => {
        this.details = res.data;
        console.log(res.data);
    })
    .catch(err => {
        console.log('エラー：' + err);
    });
    }},
    created: function() {
        this.getEstimateDetailsListById();
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