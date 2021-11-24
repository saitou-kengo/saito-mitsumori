<template>
<div>
    <div id="title">
        担当者検索
    </div>
    <br>
    <p>名前を入力してください。</p>
    <span>
        <label for="employee_name">担当者名（部分一致）</label>
        <input v-model="employeeName" type="text" id="employee_name"/>
        <button v-on:clikc="search">検索</button>
    </span>
    <br>
    <table>
        <tr>
            <th>担当者コード</th>
            <th>担当者名</th>
            <th>選択</th>
        </tr>
        <div v-for="employee in employees" :key="employee.cd">
        <tr>
            <td>{{ employee.cd }}</td>
            <td>{{ employee.name }}</td>
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
            employees: [],
        }
    },
    methods: {
        getAllEmployeeList: function() {
            axios
            .get("/api/v1/customers")
            .then((res) => {
                console.log(res);
                this.employees = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        }
    },
    created() {
        this.getAllEmployeeList();
    }
}
</script>

<style>

</style>
