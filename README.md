# Project Title

Deploy monitorting service for DevOps. Basically, the project result in setting up a monitoring script that runs at schedule interval, starts on boot, continuously.   


## Prerequisites

Ansible v2.9
Jenkins v2.225
Setup environment variables on Jenkins slave, but this is not required when using LDAP
OPS_USERNAME=<username>
OPS_PASSWORD=<password>

### Installing 

Jenkins


Role Variables
--------------

A description of the settable variables for this role should go here, including any variables that are in defaults/main.yml, vars/main.yml, and any variables that can/should be set via parameters to the role. Any variables that are read from other roles and/or the global scope (ie. hostvars, group vars, etc.) should be mentioned here as well.

Dependencies
------------

A list of other roles hosted on Galaxy should go here, plus any details in regards to parameters that may need to be set for other roles, or variables that are used from other roles.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: servers
      roles:
         - { role: username.rolename, x: 42 }

License
-------

BSD

Author Information
------------------

An optional section for the role authors to include contact information, or a website (HTML is not allowed).
