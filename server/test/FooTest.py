import unittest

from hackhomework.TaskEndpoint import TaskEndpoint


class FooTest(unittest.TestCase):
    def test_ResponseWithOneTask(self):
        endpoint = TaskEndpoint()
        endpoint.request = {"get": "parentID1"}
        response = endpoint.get()
        self.assertEquals({"tasks": [
            {"id": "1",
             "subject": "IS2",
             "limitdate": "2014-12-31",
             "description": "Happy new Year pg 1",
             "sonid": "11"}]}, response)

    def test_ResponseWithTwoTasks(self):
        endpoint = TaskEndpoint()
        endpoint.request = {"get": "parentID2"}
        response = endpoint.get()
        self.assertEquals({"tasks": [
            {"id": "1",
             "subject": "IS2",
             "limitdate": "2014-12-31",
             "description": "Happy new Year pg 1",
             "sonid": "11"},

            {"id": "2",
             "subject": "SSR",
             "limitdate": "2015-06-01",
             "description": "leer el RFC 2616",
             "sonid": "11"}]}, response)