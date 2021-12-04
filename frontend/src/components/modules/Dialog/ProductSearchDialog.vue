<template>
<modal name="productDialog" :draggable="true" :adaptive="true" :scrollable="true" width="75%" height="auto">
    <div class="container">
    <div class="form-group form-inline" id="modal-header">
        商品検索
        <br>
        商品名を入力してください
    </div>
    <div class="input-group mb-3" id="modal-search-form">
        <div class="input-group-prepend">
            <span class="input-group-text">商品名（部分一致）</span>
        </div>
        <input v-model="product.productName" type="text" id="product_name" placeholder="入力してください"/>
        <button @click="getProductListByLikeName" class="btn btn-primary" id="button">検索</button>
    </div>
    <div id="modal-body">
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="dialog-product-cd">商品コード</th>
                <th id="dialog-product-name">商品名</th>
                <th id="dialog-price">単価</th>
                <th id="dialog-select">選択</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="product in products" :key="product.cd">
                <td id="dialog-product-cd">{{ product.cd }}</td>
                <td id="dialog-product-name">{{ product.name }}</td>
                <td id="dialog-price">{{ product.price }}</td>
                <td id="dialog-select"><span @click="closeDialog(product.cd, product.name, product.price)" id="text-link">選択</span></td>
            </tr>
        </tbody>
    </table>
    </div>
    </div>
</modal>
</template>

<script>

export default {
    
    data() {
        return {
            products: null,
            product: {
                productCd: null,
                productName: null,
                price: null
            }
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
            this.$modal.show('productDialog');
        },
        closeDialog: function(productCd, productName, price) {
            this.$emit('select-product', productCd, productName, price);
            this.$modal.hide('productDialog');
        }
    },
    mounted() {
        this.getAllProductList();
    }
}
</script>
