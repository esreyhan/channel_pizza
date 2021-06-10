db.auth('admin', '12345')

db = db.getSiblingDB('ChannelPizza')

db.createUser(
{user : "pizzauser",
pwd:"12345",
roles : [{role:"readWrite",db:"ChannelPizza"}
]
})
