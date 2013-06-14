-- change here to the host an port you want to contact
local host, port = "localhost", 9876
-- load namespace
local socket = require("socket")
-- convert host name to ip address
local ip = assert(socket.dns.toip(host))
-- create a new UDP object
local udp = assert(socket.udp())
-- contact daytime host
assert(udp:sendto("LUA", ip, port))