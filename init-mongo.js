use admin

db.createUser(

 {

 user: 'admin',

 pwd: '12345',

 roles: [{ role: 'userAdminAnyDatabase', db: 'admin' }, 'readWriteAnyDatabase']

 }

)

use ChannelPizza

db.createUser(
{user : "pizzauser",
pwd:"12345",
roles : [{role:"readWrite",db:"ChannelPizza"}
]
})
