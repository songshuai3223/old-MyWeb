<template>
    <div class="box">
       <!-- <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th width="40%">name</th>
                <th width="20%">content</th>
                <th width="40%">remark</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="data in lists">
                <td v-text="data.name"></td>
                <td v-text="data.age"></td>
                <td v-text="data.address"></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="4">
                    <div class="pull-right">
                        <boot-page v-ref:page :async="false" :data="lists" :lens="lenArr" :page-len="pageLen" :param="param"></boot-page>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>-->

        <Table :columns="columns1" :data="user_list"></Table>
        <div style="position:absolute;top:0px;width:100%;height:100%;display: flex;
                            align-items: center;
                            justify-content: center;background: rgba(210, 216, 222, 0.5);" v-if="list_loadding">
            <Spin size="large"></Spin>
            <h6 style="color:#2d8cf0;margin-top:10px;">正在获取数据...</h6>
        </div>
        <div class="pull-right">
            <boot-page v-ref:page :async="false" :data="lists" :lens="lenArr" :page-len="pageLen" :param="param"></boot-page>
        </div>
    </div>
</template>

<script>
    import bootPage from './components/BootPage.vue'
    export default {
        data () {
            return {
                progresshow:false,
                progresscount:0,
                progresstatus:'active',
                progressspeed:0,
                pageindex:1,
                page_user_list:[],
                lodding:false,
                list_loadding:false,
                columns1: [
                    {
                        title: '姓名',
                        key: 'name'
                    },
                    {
                        title: '年龄',
                        key: 'age'
                    },
                    {
                        title: '地址',
                        key: 'address'
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.show(params.index)
                                        }
                                    }
                                }, '查看'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, '删除')
                            ]);
                        },
                    }
                ],
                user_list: [
                    {
                        name: '王小明',
                        age: 18,
                        address: '北京市朝阳区芍药居'
                    },
                    {
                        name: '张小刚',
                        age: 25,
                        address: '北京市海淀区西二旗'
                    },
                    {
                        name: '李小红',
                        age: 30,
                        address: '上海市浦东新区世纪大道'
                    },
                    {
                        name: '周小伟',
                        age: 26,
                        address: '深圳市南山区深南大道'
                    }
                    ,
                    {
                        name: '李小红',
                        age: 30,
                        address: '上海市浦东新区世纪大道'
                    },
                    {
                        name: '周小伟',
                        age: 26,
                        address: '深圳市南山区深南大道'
                    },{
                        name: '王小明',
                        age: 18,
                        address: '北京市朝阳区芍药居'
                    },
                    {
                        name: '张小刚',
                        age: 25,
                        address: '北京市海淀区西二旗'
                    },
                    {
                        name: '李小红',
                        age: 30,
                        address: '上海市浦东新区世纪大道'
                    },
                    {
                        name: '周小伟',
                        age: 26,
                        address: '深圳市南山区深南大道'
                    }
                    ,
                    {
                        name: '李小红',
                        age: 30,
                        address: '上海市浦东新区世纪大道'
                    },
                    {
                        name: '周小伟',
                        age: 26,
                        address: '深圳市南山区深南大道'
                    }
                ]
            }
        },
        components: {
            bootPage
        },
        methods: {
            show (index) {
                this.$Modal.info({
                    title: '用户信息',
                    content: `姓名：${this.user_list[index].name}<br>年龄：${this.user_list[index].age}<br>地址：${this.user_list[index].address}`
                })
            },
            remove (index) {
                this.user_list.splice(index, 1);
            },
            setInitPage(page)
            {
                var pagesize=4
                this.page_user_list=[];
                this.pageindex=page;
                let user_list=this.user_list;
                for(let i=(page-1)*pagesize;i<(page-1)*pagesize+pagesize;i++)
                {
                    if(i<user_list.length)
                    {
                        this.page_user_list.push(this.user_list[i]);
                    }
                }
            }

        },
        events: {
            // 分页组件传回的表格数据
            'data' (data) {
                this.tableList = data
            },
            // 刷新数据
            'refresh' () {
                this.refresh()
            }
        }
    }
</script>

<style>
 @import url('./assets/css/bootstrap.min.css');
    .box {
        padding: 100px;
    }
</style>