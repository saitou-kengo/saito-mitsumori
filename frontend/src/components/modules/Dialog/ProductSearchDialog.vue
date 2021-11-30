<template>
<div>
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div id="title">
        商品検索
    </div>
    <br>
    <p>商品名を入力してください。</p>
    <span>
        <label for="product_name">商品名（部分一致）</label>
        <input v-model="product.name" type="text" id="product_name"/>
        <button @click="getProductListByLikeName">検索</button>
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
            <td><span @click="closeDialog(product)">選択</span></td>
        </tr>
        </div>
    </table>
    </div>
    </div>
</div>
</template>

<script>

export default {
    
    data() {
        return {
            products: null,
            product: {
                productCd: null,
                productName: "商品名を入力してください",
                price: null
            },
            showFlag: false
        }
    },
    methods: {
        getAllProductList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/products')
            .then((res) => {
                console.log(res);
                this.products = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getProductListByLikeName: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/products/name/:name', {
                params: {
                    name: this.product.productName
                }
            })
            .then(res => {
                this.products = res.data;
            })
            .catch(err => {
                console.log('エラー：' + err);
            })
        },
        showDialog: function() {
            this.showFlag = true;
        },
        closeDialog: function(product) {
            this.$emit('select-product', product);
            this.showFlag = false;
        }
    },
    mounted() {
        this.getAllProductList();
    }
}
</script>

<style>
#overlay{
    z-index: 1;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.5);
    display: flex;
    align-items: center;
    justify-content: center;
}

#dialog{
    z-index: 2;
    width: 50%;
    padding: 1em;
    background: #fff;

}
</style>
