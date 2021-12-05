<template>
<modal name="employee-dialog" :draggable="true" :adaptive="true" :scrollable="true" width="75%" height="auto">
    <div clas="container">
        <div class="row margin-15" id="modal-header">
            <div class="col">
                <span class="page-title">
                    担当者検索
                </span>
                <br>
                名前を入力してください。
            </div>
        </div>
        <div class="row margin-15">
            <div class="col">
                <div class="input-group mb-1" id="modal-search-form">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            担当者名（部分一致）
                        </span>
                    </div>
                    <input v-model="employeeName" type="text" class="col-md-3" id="employee_name" placeholder="入力してください"/>
                    <button @click="getEmployeeListByLikeName" class="btn btn-primary" id="button">検索</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <span id="index">
                    検索結果
                </span>
            </div>
        </div>
        <div class="row" id="modal-body">
            <div class="col">
                <table class="table table-bordered">
                    <thead class="thead-lignt">
                        <tr>
                            <th id="dialog-employee-cd">
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-calendar-plus-fill" viewBox="0 0 16 16" color="black">
                                <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM8.5 8.5V10H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V11H6a.5.5 0 0 1 0-1h1.5V8.5a.5.5 0 0 1 1 0z"/>
                                </svg>
                                担当者コード
                            </th>
                            <th id="dialog-employee-name">
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="black">
                                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                                </svg>
                                担当者名
                            </th>
                            <th id="dialog-select">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                </svg>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="employee in employees" :key="employee.cd">
                            <td id="dialog-employee-cd">{{ employee.cd }}</td>
                            <td id="dialog-employee-name">{{ employee.name }}</td>
                            <td id="dialog-select"><span @click="closeDialog(employee.cd, employee.name)" id="text-link">選択</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</modal>
</template>

<script>
export default {
    data() {
        return {
            employees: null,
            employeeName: null
        }
    },
    methods: {
        getAllEmployeeList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/employees')
            .then((res) => {
                this.employees = res.data;
                console.log('retrieve all Employee');
            })
            .catch((err) => {
                console.log('Error：' + err);
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
                console.log('retrieve a Employee by :name');
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        showDialog: function() {
            this.$modal.show('employee-dialog');
        },
        closeDialog: function(employeeCd, employeeName) {
            this.$emit('select-employee', employeeCd, employeeName);
            this.$modal.hide('employee-dialog');
        }
    },
    created() {
        this.getAllEmployeeList();
    }
}
</script>
