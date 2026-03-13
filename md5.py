import hashlib

str = "hello_world"

encoded = str.encode("utf-8")
hash = hashlib.md5(encoded).hexdigest()

print(f"MD5 Hash of '{str}': {hash}")