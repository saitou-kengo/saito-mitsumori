<template>
<div>
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div id="title">
        担当者検索
    </div>
    <br>
    <p>名前を入力してください。</p>
    <span>
        <label for="employee_name">担当者名（部分一致）</label>
        <input v-model="employeeName" type="text" id="employee_name"/>
        <button @click="getEmployeeListByLikeName">検索</button>
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
            <td><span @click="closeDialog(employee.name)">選択</span></td>
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
            employees: null,
            employeeName: "入力してください",
            showFlag: false
        }
    },
    methods: {
        getAllEmployeeList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/employees')
            .then((res) => {
                this.employees = res.data;
            })
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getEmployeeListByLikeName: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/employees/name/:cd', {
                params: {
                    name: this.employeeName
                }
            })
        .then(res => {
            this.employees = res.data;
        })
        .catch(err => {
            console.log("エラー：" + err);
        })
        },
        showDialog: function() {
            this.showFlag = true;
        },
        closeDialog: function(employeeName) {
            this.$emit('select-employee', employeeName);
            this.showFlag = false;
        }
    },
    created() {
        this.getAllEmployeeList();
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
