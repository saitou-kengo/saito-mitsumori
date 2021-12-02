<template>
<div>
    <span id="index">見積明細</span>
    <br>
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
            <th id="subId">枝番</th>
            <th id="productName">商品名</th>
            <th id="price">単価</th>
            <th id="quantity">数量</th>
            <th id="totalPrice">金額</th>
            <th id="delete">削除</th>
            </tr>
        </thead>
        <tbody>
        <tr v-for="detail in details" :key="detail.id">
            <td id="subId">{{ detail.subId }}</td>
            <td id="productName">{{ detail.productName }}</td>
            <td id="price">{{ detail.price }}</td>
            <td id="quantity">{{ detail.quantity }}</td>
            <td id="totalPrice">{{ detail.totalPrice }}</td>
            <td id="delete"><div @click="deleteDetail(detail.id)">削除</div></td>
        </tr>
        </tbody>
    </table>
</div>
</template>

<script>

export default {
    props: ['details'],
    methods: {
        deleteDetail: function(id) {
            this.$emit('delete-detail', id);
        }
    }
}
</script>

<style>
table {
    margin: auto;
}

#subId {
    width: 5%;
}

#productName {
    width: 25%;
}

#price {
    width: 10%;
}

#quantity {
    width: 5%;
}

#totalPrice {
    width: 10%;
}

#delete {
    width: 10%;
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