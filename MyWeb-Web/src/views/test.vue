<template>
    <div class="animated fadeIn">
        <h3>框架在手，天下我有</h3>
        <p>好用的框架决定了一个程序员的效率</p>
        <Table :columns="columns1" :data="user_list"></Table>
        <div style="position:absolute;top:0px;width:100%;height:100%;display: flex;
                            align-items: center;
                            justify-content: center;background: rgba(210, 216, 222, 0.5);" v-if="list_loadding">
            <Spin size="large"></Spin>
            <h6 style="color:#2d8cf0;margin-top:10px;">正在获取数据...</h6>
        </div>
        <Page :total="this.user_list.length" show-total @on-change="setInitPage" style="text-align:right;margin-top:50px"></Page>
    </div>
</template>

<script>
    export default {
        name: "test",
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
    }
</script>
<style type="text/css" scoped>
    .ivu-tag-dot{
        border: none!important;
    }
    tr.ivu-table-row-hover td .ivu-tag-dot{
        background-color: #ebf7ff!important;
    }

    .demo-i-circle-custom h1{
        color: #3f414d;
        font-size: 10px;
        font-weight: normal;
    }
    .demo-i-circle-custom p{
        color: #657180;
        font-size: 8px;
        margin: 5px 0 2px;
    }
    .demo-i-circle-custom span{
        display: block;
        padding-top: 15px;
        color: #657180;
        font-size: 10px;}
    .demo-i-circle-custom span :before{
        content: '';
        display: block;
        width: 50px;
        height: 1px;
        margin: 0 auto;
        background: #e0e3e6;
        position: relative;
        top: -20px;
    };
    .demo-i-circle-custom span i{
        font-style: normal;
        color: #3f414d;
    }

    .ivu-btn.ivu-btn-primary.ivu-btn-small:not(.ivu-btn-loading ){
        padding :2px 10px!important;
    }
    td.ivu-table-expanded-cell{
        background-color: white!important;

    }
</style>



