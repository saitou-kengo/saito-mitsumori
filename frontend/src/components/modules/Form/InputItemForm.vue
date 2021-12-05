<template>
<div class="container">
    <div class="row margin-15">
        <div class="col">
            <span id="index">
                追加商品
            </span>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        商品コード
                    </span>
                </div>
                <input v-model="product.productCd" class="col-md-3" type="text" disabled="disabled" placeholder="商品を選択してください"/>
                <button @click="showProductSearchDialog" class="btn btn-primary" id="button">商品検索</button>
                <product-search-dialog ref="pDialog"
                    @select-product='initProduct'
                />
                <div class="offset-1"></div>
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        商品名
                    </span>
                </div>
                <input v-model="product.productName" class="col-md-4" type="text" disabled="disabled" placeholder="商品を選択してください"/>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        単価
                    </span>
                </div>
                <input v-model="product.price" class="col-md-3" type="text" disabled="disabled" placeholder="商品を選択してください"/>
                <button @click="clearProduct" class="btn btn-secondary" id="button">商品をクリア</button>
                <div class="offset-1"></div>
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        数量
                    </span>
                </div>
                <input v-model="detail.quantity" class="col-md-4" type="text" placeholder="数量を入力して下さい"/>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="grey">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                        </svg>
                        金額
                    </span>
                </div>
                <input v-model="budgeted" class="col-md-4" type="text" disabled="disabled"/>
            </div>
        </div>
    </div>
    <div class="row margin-15">
        <div class="col">
            <div class="input-group mb-1">
                <button @click="addDetail" class="btn btn-success" id="button" :disabled="isAddDetail">明細に追加</button>
            </div>
        </div>
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
        budgeted() {
            return (this.detail.quantity >= 0 && this.product.price >=0 ? this.product.price * this.detail.quantity : "-");
        },
        isAddDetail() {
            return this.product.productCd == null || this.detail.quantity == null;
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
