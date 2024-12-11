Base URL: http://localhost:8080

数据格式: JSON

接口类型: RESTful API

接口列表


1. 通知管理


1.1 发布通知

URL: /api/notifications

方法: POST

请求头:
Content-Type: application/json

请求体:
json

Copy code

{
    "title": "通知标题",
    "content": "通知内容",
    "author": "发布人"
}

响应:
json

Copy code

{
    "id": 1,
    "title": "通知标题",
    "content": "通知内容",
    "author": "发布人"
}

说明: 用于创建一条新的通知。


1.2 获取所有通知

URL: /api/notifications

方法: GET

响应:
json

Copy code

[
    {
        "id": 1,
        "title": "通知标题",
        "content": "通知内容",
        "author": "发布人"
    }
]

说明: 返回所有通知的列表。


1.3 删除通知

URL: /api/notifications/{id}

方法: DELETE

路径参数:
id：通知的唯一标识

响应: 无内容，状态码 204 No Content

说明: 删除指定 ID 的通知。



2. 资源管理


2.1 上传资源

URL: /api/resources

方法: POST

请求头:
Content-Type: application/json

请求体:
json

Copy code

{
    "name": "资源名称",
    "filePath": "/path/to/resource"
}

响应:
json

Copy code

{
    "id": 1,
    "name": "资源名称",
    "filePath": "/path/to/resource"
}

说明: 用于上传一个新的资源。


2.2 获取所有资源

URL: /api/resources

方法: GET

响应:
json

Copy code

[
    {
        "id": 1,
        "name": "资源名称",
        "filePath": "/path/to/resource"
    }
]

说明: 返回所有资源的列表。


2.3 删除资源

URL: /api/resources/{id}

方法: DELETE

路径参数:
id：资源的唯一标识

响应: 无内容，状态码 204 No Content

说明: 删除指定 ID 的资源。
