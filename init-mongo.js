use ChannelPizza

db.createUser(
{user : "pizzauser",
pwd:"12345",
roles : [{role:"userAdmin",db:"ChannelPizza"}]})

use ChannelPizza