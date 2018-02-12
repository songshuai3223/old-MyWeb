<template>
    <div class="components-container">
        <Row :gutter="20">

            <Col :span="3" >
                <Button type="success">查询</Button>
                <div class="code-list">
                    <row>1</row>
                    <row>1</row>
                    <row>1</row>
                    <row>1</row>
                </div>
            </Col>
            <Col span="19">
            <div>
                <div style="" class="doc-header">
                    <Form :model="formItem" :label-width="80">
                        <Row>
                            <Col  span="6">类型名</Col>
                            <Col  span="6">类型</Col>
                            <Col  span="6">描述</Col>
                            <Col  span="6">影像</Col>
                        </Row>
                        <Row>
                            <Col  span="6">类型名</Col>
                            <Col  span="6">类型</Col>
                            <Col  span="6">描述</Col>
                            <Col  span="6">影像</Col>
                        </Row>
                    </Form>
                </div>
            </div>
            <Button type="success" onclick="newCode">新建代码</Button>
            <Button type="info">删除代码类型</Button>
            <div>
                <div style="position:relative;">
                    <Table  :columns="columns7" :data="page_video_list" ref="table"></Table>
                    <div style="position:absolute;top:0px;width:100%;height:100%;display: flex;
                            align-items: center;
                            justify-content: center;background: rgba(210, 216, 222, 0.5);" v-if="list_loadding">
                        <Spin size="large"></Spin>
                        <h6 style="color:#2d8cf0;margin-top:10px;">正在获取数据...</h6>
                    </div>
                </div>

                <Page :total="this.video_list.length" show-total @on-change="setInitPage" style="text-align:right;margin-top:50px"></Page>
            </div>
            </Col>
        </Row>
    </div>
</template>
<script>
    var vue;
    var uploader;
    function newCode() {
        this.$Modal.info({
            title: '编辑代码',
            content: `代码：<Input placeholder="代码"></Input><br>代码值：<Input placeholder="代码值"></Input>}<br>描述：<Input placeholder="描述"></Input>}`
        })
    }

    function qiniuInit(vue){

        uploader = Qiniu.uploader({
            runtimes: 'html5,flash,html4',      // 上传模式，依次退化
            browse_button: 'pickfiles',         // 上传选择的点选按钮，必需
            uptoken_func: function(){    // 在需要获取uptoken时，该方法会被调用
                // return "123";
            },
            domain: 'http://qiniu-plupload.qiniudn.com/',     // bucket域名，下载资源时用到，必需
            container: 'container',             // 上传区域DOM ID，默认是browser_button的父元素
            max_file_size: '1024mb',             // 最大文件体积限制
            flash_swf_url: 'static/bower_components/plupload/js/Moxie.swf',  //引入flash，相对路径
            filters : {
            },
            init: {
            }
        });
    }
    export default {
        name: 'buttons',
        data () {
            return {
                progresshow:false,
                progresscount:0,
                progresstatus:'active',
                progressspeed:0,
                video_list:[
                    {
                        task_status:0,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                    {
                        task_status:1,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                    {
                        task_status:1,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                    {
                        task_status:0,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                    {
                        task_status:1,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                    {
                        task_status:0,
                        timestamp:"2017-08-10 17:03:54",
                        video_duration:"11s",
                        video_size:1732410,
                        video_name:"p.mp4",
                    },
                ],
                pageindex:1,
                page_video_list:[],
                lodding:false,
                list_loadding:false,
                columns7: [
                    {
                        title: '视频名称',
                        key: 'video_name',
                        ellipsis:'true',
                    },
                    {
                        title: '上传时间',
                        ellipsis:'true',
                        key: 'timestamp',

                    },

                    {
                        title: '时长',
                        ellipsis:'true',
                        key:'video_duration',
                    },
                    {
                        title: '大小',
                        ellipsis:'true',
                        key:'video_size',
                        filters: [
                            {
                                label: '大于10M',
                                value: 1
                            },
                            {
                                label: '小于10M',
                                value: 2
                            }
                        ],
                        filterMultiple: false,
                        filterMethod (value, row) {
                            if (value === 1) {
                                return row.video_size>1024*1024*1024*10;
                            } else if (value === 2) {
                                return row.video_size<1024*1024*10;
                            }
                        }
                    },
                    {
                        title: '状态',
                        ellipsis:'true',
                        filters: [
                            {
                                label: '处理完成',
                                value: 1
                            },
                            {
                                label: '正在处理',
                                value: 2
                            }
                        ],
                        filterMultiple: false,
                        filterMethod (value, row) {
                            if (value === 1) {
                                return row.task_status===1;
                            } else if (value === 2) {
                                return row.task_status===0;
                            }
                        },

                        render: (h, params) => {
                            const task_status=parseInt(params.row.task_status);

                            if(task_status===0)
                                return h('div', [
                                    h('Tag', {
                                        props: {
                                            type: 'dot',
                                            color: "blue"
                                        }
                                    }, "正在处理"),
                                ]);

                            else if(task_status===1)
                                return h('div', [

                                    h('Tag', {
                                        props: {
                                            type: 'dot',
                                            color: "green"
                                        }
                                    }, "处理完成"),
                                ]);
                        }
                    },

                    {
                        title: '操作',
                        key: 'action',
                        align: 'center',
                        ellipsis:'true',

                        render: (h, params) => {
                            const task_status=parseInt(params.row.task_status);
                            if(task_status===0)
                            {
                                return h('div', [
                                    h('Tooltip',{
                                        props: {
                                            content: '还未分析完成，暂时不能查看',
                                        },
                                    },[
                                        h('Button', {
                                            props: {
                                                type: 'primary',
                                                size: 'small',
                                                loading:true,
                                            },
                                            style: {
                                                marginRight: '5px'
                                            },
                                        }, '处理中')]),
                                    h('Button', {
                                        props: {
                                            type: 'error',
                                            size: 'small',
                                            disabled:true,
                                        },
                                        on: {
                                            click: () => {
                                                this.remove(params.index)
                                            }
                                        }
                                    }, '删除')


                                ]);
                            }
                            else if(task_status===1){
                                return h('div', [
                                    h('Button', {
                                        props: {
                                            type: 'primary',
                                            size: 'small',
                                        },
                                        style: {
                                            marginRight: '5px'
                                        },
                                        on: {
                                            click: () => {
                                                this.$router.push({path:'/tabledetail/'+(((this.pageindex-1)*10)+params.index) })

                                            }
                                        },
                                    }, '查看结果'),
                                    h('Button', {
                                        props: {
                                            type: 'error',
                                            size: 'small',
                                        },
                                        on: {
                                            click: () => {
                                                this.remove(params.index)
                                            }
                                        }
                                    }, '删除')
                                ]);
                            }
                        }//render
                    },//{
                ],//cloumn
            }//return
        },//data
        methods: {
            remove (index) {
                this.video_list.splice(index, 1);
            },
            setInitPage(page)
            {

                this.page_video_list=[];
                this.pageindex=page;
                let video_list=this.video_list;
                for(let i=(page-1)*10;i<(page-1)*10+10;i++)
                {


                    if(i<video_list.length)
                    {

                        this.page_video_list.push(this.video_list[i]);

                    }
                }
            }
        },
        mounted(){
            const vue=this;

            this.list_loadding=true;
            setTimeout(function(){
                vue.list_loadding=false;

            },2000)
            qiniuInit(vue);//初始化七牛数据
            this.setInitPage(1);
        },
    }
</script>

<style scoped>
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
    .code-list{
        background-color: #ccd7e5;
        font-size: larger;
    }
    .code-list :hover{
        background-color: seashell;
        font-size: large;
    }
</style>


