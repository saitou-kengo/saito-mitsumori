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
        </tr>
        </thead>
        <tbody>
        <tr v-for="detail in details" :key="detail.id">
            <td id="subId">{{ detail.subId }}</td>
            <td id="productName">{{ detail.productName }}</td>
            <td id="price">{{ detail.price }}</td>
            <td id="quantity">{{ detail.quantity }}</td>
            <td id="totalPrice">{{ detail.totalPrice }}</td>
        </tr>
        </tbody>
        </table>
</div>
</template>

<script>

export default {
    props: ['details']
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