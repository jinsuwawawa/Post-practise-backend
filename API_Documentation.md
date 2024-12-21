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

{
    "name": "资源名称",
    "filePath": "/path/to/resource",
    "uploadDate": "2024-01-01T00:00:00",
    "course": {
        "id": 1
    }
}
字段说明:

name：资源的名称，字符串类型。
filePath：资源文件的路径，字符串类型。
uploadDate：资源的上传时间，ISO 8601 格式。
course：关联的课程信息。
id：课程的唯一标识，整型。
响应:

json

{
    "id": 1,
    "name": "资源名称",
    "filePath": "/path/to/resource",
    "uploadDate": "2024-01-01T00:00:00",
    "course": {
        "id": 1,
        "title": "Math 101",
        "description": "Basic Mathematics",
        "credit": 3
    }
}
说明: 该接口用于上传一个新的资源，同时可以指定关联的课程（通过 course.id）。

2.2 获取所有资源
URL: /api/resources
方法: GET
响应:
json


[
    {
        "id": 1,
        "name": "资源名称",
        "filePath": "/path/to/resource",
        "uploadDate": "2024-01-01T00:00:00",
        "course": {
            "id": 1,
            "title": "Math 101",
            "description": "Basic Mathematics",
            "credit": 3
        }
    }
]
说明: 返回所有资源的列表，每个资源都包含其关联的课程信息。
