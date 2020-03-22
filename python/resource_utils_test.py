"""Tests for resource_utils module."""

import json
import unittest

import resource_utils
import resources


class ResourceUtilsTestCase(unittest.TestCase):
    """Tests for resource_utils.py"""

    def test_read_write(self):
        """Verify that a resource is read and written correctly."""
        term_dict = {
            'phrase': 'orange',
            'definition': 'A round fruit',
            'contributor': {
                'handle': 'abc'
            }
        }
        term = resources.Term.from_dict(term_dict)
        term.language = resources.Language.INFORMAL
        resource_utils.write_json('testdata', 'orange', term)

        [assignable_id, read_term] = resource_utils.read_resource(
            'testdata', 'T_orange.json')
        self.assertEqual(assignable_id, "orange")
        self.assertEqual(_resource_to_string(
            read_term), _resource_to_string(term))
        print(_resource_to_string(read_term))


def _resource_to_string(resource):
    return json.dumps(resource_utils.remove_nulls(resource.to_dict()), indent=2)


if __name__ == '__main__':
    unittest.main()
