local clock = os.clock
function sleep(n)  -- seconds
  local t0 = clock()
  while clock() - t0 <= n do end
end

-- change here to the host an port you want to contact
local host, port = "localhost", 9876
-- load namespace
local socket = require("socket")
-- convert host name to ip address
local ip = assert(socket.dns.toip(host))
-- create a new UDP object
local udp = assert(socket.udp())

count = 0;
while true do
	-- contact daytime host
	flow = (count % 10) + 1
	msg = "3,"..flow..",1.0,"
	assert(udp:sendto(msg, ip, port))
	print (msg)
	count = count + 1
	sleep(1)
end
