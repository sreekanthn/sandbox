import sqllite3
connection = sqlite3 .connect("Hand_tools.db")
cursor = connection . cursor () #Alternative DB created only in memory #]
m_conn = sqlite3 . connect (":memory:") #
cursor = mem_conn. cursor ()
cursor.execute("""CREATE TABLE Tools (id INTEGER PRIMARY KEY, name TEXT, size TEXT, price INTEGER)""") for item in ( (None, "Knife", "Small", 15),
#The end comma is required to separate tuple items
(None, "Machete", "Medium", 35),
(None, "Axe", "Large", 55),
(None, "Hatchet", "Small", 25),
(None, "Hammer", "Small", 25) ,
(None, "Screwdriver", "Small", 10),
(None, "Prybar", "Large", 60),
