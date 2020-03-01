import json
from resources import Term, Proposition, Argument, Beliefset, Article, Project

def get_resource_code(resource):
    if isinstance(resource, Term):
        return 'T'
    if isinstance(resource, Proposition):
        return 'P'
    if isinstance(resource, Argument):
        return 'A'
    if isinstance(resource, Beliefset):
        return 'B'
    if isinstance(resource, Article):
        return 'R'
    if isinstance(resource, Project):
        return 'J'


def remove_nulls(d):
    if not isinstance(d, dict):
        return d
    return {k: remove_nulls(v) for k, v in d.items() if v is not None}


def get_filename(assignable_id, resource):
    return get_resource_code(resource) + '_' + assignable_id + '.json'


def write_json(assignable_id, resource):
    with open(get_filename(assignable_id, resource), 'w') as fp:
        json.dump(remove_nulls(resource.to_dict()), fp, indent=2)


def resource_from_dict(resource_code, json_data):
    if resource_code == 'T':
        return Term.from_dict(json_data)
    if resource_code == 'P':
        return Proposition.from_dict(json_data)
    if resource_code == 'A':
        return Argument.from_dict(json_data)
    if resource_code == 'B':
        return Beliefset.from_dict(json_data)
    if resource_code == 'R':
        return Article.from_dict(json_data)
    if resource_code == 'J':
        return Project.from_dict(json_data)
    return None


def read_resource(filename):
    json_data = json.loads(open(filename, "r").read())
    resource = resource_from_dict(filename[0], json_data)
    return [filename[2: -5], resource]
