class ResponseBuilder(object):
    def __init__(self, parentID):
        self.parentID = parentID

    def build(self):
        if self.parentID == "parentID1":
            return {"tasks": [
                {"id": 1,
                 "subject": "MAT",
                 "limitdate": "2015-06-01",
                 "description": "Libro pág. 25, ej: 3, 4, 5",
                 "sonid": 12},

                {"id": 2,
                 "subject": "MAT",
                 "limitdate": "2015-06-01",
                 "description": "Libro pág. 25, ej: 3, 4, 5",
                 "sonid": 12}]}

        return {"tasks": [
            {"id": 5,
             "subject": "MAT",
             "limitdate": "2015-06-01",
             "description": "Libro pág. 25, ej: 3, 4, 5",
             "sonid": 11},

            {"id": 6,
             "subject": "LAN",
             "limitdate": "2015-06-01",
             "description": "Libro pág. 17, ej: 13a, 13b, 19",
             "sonid": 11},

            {"id": 7,
             "subject": "SCI",
             "limitdate": "2015-06-01",
             "description": "Libro pág. 25, ej: 3, 4, 5, 6, 7, 8, 9",
             "sonid": 11},

            {"id": 8,
             "subject": "ENG",
             "limitdate": "2015-12-31",
             "description": "Libro, pág. 52, ej: 8b; Libro E pág. 34 ej: 19c",
             "sonid": 11},

            {"id": 9,
             "subject": "ENG",
             "limitdate": "2015-12-31",
             "description": "Libro, pág. 52, ej: 8b; Libro E pág. 34 ej: 19c",
             "sonid": 11},

            {"id": 10,
             "subject": "ENG",
             "limitdate": "2015-12-31",
             "description": "Libro, pág. 52, ej: 8b; Libro E pág. 34 ej: 19c",
             "sonid": 11}]}