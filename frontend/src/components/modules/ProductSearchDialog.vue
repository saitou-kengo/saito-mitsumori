<template>
<div>
    <div id="title">
        商品検索
    </div>
    <br>
    <p>商品名を入力してください。</p>
    <span>
        <label for="product_name">商品名（部分一致）</label>
        <input v-model="productName" type="text" id="product_name"/>
        <button v-on:clikc="search">検索</button>
    </span>
    <br>
    <table>
        <tr>
            <th>商品コード</th>
            <th>商品名</th>
            <th>単価</th>
            <th>選択</th>
        </tr>
        <div v-for="product in products" :key="product.cd">
        <tr>
            <td>{{ product.cd }}</td>
            <td>{{ product.name }}</td>
            <td>{{ product.price }}</td>
            <td><router-link :to="{ name:'edit',params:{ id : estimate.id }}">選択</router-link></td>
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
            products: [],
        }
    },
    methods: {
        getAllProductList: function() {
            axios
            .get("/api/v1/products")
            .then((res) => {
                console.log(res);
                this.products = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        }
    },
    created() {
        this.getAllProductList();
    }
}
</script>

<style>

</style>
