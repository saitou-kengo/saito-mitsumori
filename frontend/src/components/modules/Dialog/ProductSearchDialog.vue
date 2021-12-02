<template>
<div class="container">
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div class="form-group form-inline" v id="title">
        商品検索
    </div>
    <br>
    <p>商品名を入力してください。</p>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">商品名（部分一致）</span>
        </div>
        <input v-model="product.name" type="text" id="product_name" placeholder="入力してください"/>
        <button @click="getProductListByLikeName" class="btn btn-primary">検索</button>
    </div>
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="productCd">商品コード</th>
                <th id="productName">商品名</th>
                <th id="price">単価</th>
                <th id="select">選択</th>
            </tr>
        </thead>
        <tbody>
        <div v-for="product in products" :key="product.cd">
            <tr>
                <td id="productCd">{{ product.cd }}</td>
                <td id="productName">{{ product.name }}</td>
                <td id="price">{{ product.price }}</td>
                <td id="select"><span @click="closeDialog(product.cd, product.name, product.price)">選択</span></td>
            </tr>
        </div>
        </tbody>
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
                productName: null,
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
        closeDialog: function(productCd, productName, price) {
            this.$emit('select-product', productCd, productName, price);
            this.showFlag = false;
        }
    },
    mounted() {
        this.getAllProductList();
    }
}
</script>

<style>
table {
    margin: auto;
}

tbody {
    overflow: scroll;
}

#productCd {
    width: 15%;
}

#productName {
    width: 50%;
}

#price {
    width: 20%;
}

#select {
    width: 15%;
}


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
