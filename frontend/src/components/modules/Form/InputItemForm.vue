<template>
<div>
    <span id="index">追加商品</span>
    <br>
    <span>
        <label for="item_code">商品コード</label>
        <input v-model="product.productCd" type="text" disabled="disabled"/>
        <button @click="showProductSearchDialog">商品検索</button>
        <product-search-dialog ref="pDialog"
            @select-product='product = $event'
        />
    </span>
    <span>
        <label for="item_name">商品名</label>
        <input v-model="product.productName" type="text" disabled="disabled"/>
    </span>
    <br>
    <span>
        <label for="price">単価</label>
        <input v-model="product.price" type="text" disabled="disabled"/>
        <button @click="clearProduct">商品をクリア</button>
    </span>
    <span>
        <label for="quantity">数量</label>
        <input v-model="detail.quantity" type="text"/>
    </span>
    <br>
    <span>
        <label for="total_price">金額</label>
        <input v-model="totalPrice" type="text" disabled="disabled"/>
    </span>
    <br>
    <button @click="addDetail">明細に追加</button>
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
                productCd: "商品を選択してください",
                productName: "商品を選択してください",
                price: "商品を選択してください",
            },
            detail: {
                quantity: "数量を入力してください",
            }
        }
    },
    computed: {
    totalPrice: function() {
        return (this.detail.quantity >= 0 && this.product.price >=0 ? this.product.price * this.detail.quantity : "-");
    }
    },
    methods: {
        addDetail: function() {
            this.$emit('add-detail', this.detail, this.product);
        },
        clearProduct: function() {
            this.product.productCd = null;
            this.product.productName = null;
            this.product.price = null,
            this.detail.quantity = null,
            this.detail.totalPrice = null
        },
        showProductSearchDialog: function() {
            this.$refs.pDialog.showDialog();
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