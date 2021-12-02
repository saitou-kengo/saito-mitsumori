<template>
<div class="container">
    <span id="index">追加商品</span>
    <br>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">商品コード</span>
        </div>
        <input v-model="product.productCd" type="text" disabled="disabled" placeholder="商品を選択してください"/>
        <button @click="showProductSearchDialog" class="btn btn-primary">商品検索</button>
        <product-search-dialog ref="pDialog"
            @select-product='initProduct'
        />
        <div class="input-group-prepend">
            <span class="input-group-text">商品名</span>
        </div>
        <input v-model="product.productName" type="text" disabled="disabled" placeholder="商品を選択してください"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">単価</span>
        </div>
        <input v-model="product.price" type="text" disabled="disabled" placeholder="商品を選択してください"/>
        <button @click="clearProduct" class="btn btn-secondary">商品をクリア</button>
        <div class="input-group-prepend">
            <span class="input-group-text">数量</span>
        </div>
        <input v-model="detail.quantity" type="text" placeholder="数量を入力して下さい"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">金額</span>
        </div>
        <input v-model="budgeted" type="text" disabled="disabled"/>
    </div>
    <div class="input-group mb-3">
        <button @click="addDetail" class="btn btn-success">明細に追加</button>
    </div>
</div>
</template>

<script>
import ProductSearchDialog from '../Dialog/ProductSearchDialog.vue'

export default {
    components: {
        ProductSearchDialog
    },
    data() {
        return {
            product: {
                productCd: null,
                productName: null,
                price: null
            },
            detail: {
                quantity: null
            }
        }
    },
    computed: {
    budgeted: function() {
        return (this.detail.quantity >= 0 && this.product.price >=0 ? this.product.price * this.detail.quantity : "-");
    }
    },
    methods: {
        addDetail: function() {
            this.$emit('add-detail', this.detail, this.product, this.budgeted);
            this.clearProduct();
        },
        clearProduct: function() {
            this.product.productCd = null;
            this.product.productName = null;
            this.product.price = null,
            this.detail.quantity = null
        },
        showProductSearchDialog: function() {
            this.$refs.pDialog.showDialog();
        },
        initProduct: function(productCd, productName, price) {
            this.product.productCd = productCd;
            this.product.productName = productName;
            this.product.price = price;
        }
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