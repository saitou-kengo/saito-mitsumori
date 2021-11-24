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
        </tr>
        <div v-for="detail in details" :key="detail.id">
        <tr>
            <td>{{ detail.subId }}</td>
            <td>{{ detail.productName }}</td>
            <td>{{ detail.price }}</td>
            <td>{{ detail.quantity }}</td>
            <td>{{ detail.totalPrice }}</td>
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
            details: [],
        }
    },
    methods: {
        getAllDetailList: function() {
            axios
            .get("/api/v1/estimate-details")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        }
    },
    created() {
        this.getAllDetailList();
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