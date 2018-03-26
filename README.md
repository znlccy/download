# 统计网站下载和访问量

## 1.实现统计，添加数据

~~~
Request: http://域名:端口/download
Method: GET
Response: null
~~~

## 2.实现统计，返回访问量数据和下载数据

~~~
Request: http://域名:端口/statistics
Method: POST
Header: 
{
    'Content-Type':'application/json'
}
Body:
{
    "beginTime": "2018-3-26",
    "endTime": "2018-3-27"
}
Response: 
{
    "code": "1200",
    "data": {
        "accessCount": "1",
        "downloadCount": "3"
    },
    "message": "Success"
}
~~~

>Download主要是统计SDK下载次数了访问次数

### 目录结构
+ controller  -->控制器层
+ mapper -->Dao层
+ model -->Bean层
+ request -->请求层
+ response -->响应层
+ service -->服务层接口
+ serviceImpl -->服务层接口实现层
+ utils -->工具层
