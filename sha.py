import hashlib

msg = "hello_world"

# convert to bytes
msg = msg.encode()

# SHA-1
print("SHA-1:", hashlib.sha1(msg).hexdigest())

# SHA-256
print("SHA-256:", hashlib.sha256(msg).hexdigest())

# SHA-512
print("SHA-512:", hashlib.sha512(msg).hexdigest())