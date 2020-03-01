import json
import resources
import resource_utils

term_dict = {
    'phrase': 'orange',
    'definition': 'A round fruit',
    'contributor': {
        'handle': 'abc'
    }
}
term = resources.Term.from_dict(term_dict)
term.language = resources.Language.INFORMAL
resource_utils.write_json('orange', term)

[assignable_id, read_term] = resource_utils.read_resource('T_orange.json')
print(json.dumps(resource_utils.remove_nulls(read_term.to_dict()), indent=2))
