<template>
<div>
    <span id="index">見積明細</span>
    <br>
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
            <th id="sub-id">枝番</th>
            <th id="product-name">商品名</th>
            <th id="price">単価</th>
            <th id="quantity">数量</th>
            <th id="total-price">金額</th>
            <th id="delete">削除</th>
            </tr>
        </thead>
        <tbody>
        <tr v-for="detail in details" :key="detail.id">
            <td id="sub-id">{{ detail.subId }}</td>
            <td id="product-name">{{ detail.productName }}</td>
            <td id="price">{{ detail.price }}</td>
            <td id="quantity">{{ detail.quantity }}</td>
            <td id="total-price">{{ detail.totalPrice }}</td>
            <td id="delete"><div @click="deleteDetail(detail.id, detail.totalPrice)" id="text-link">削除</div></td>
        </tr>
        </tbody>
    </table>
</div>
</template>

<script>

export default {
    props: ['details'],
    methods: {
        deleteDetail: function(id, totalPrice) {
            this.$emit('delete-detail', id, totalPrice);
        }
    }
}
</script>
