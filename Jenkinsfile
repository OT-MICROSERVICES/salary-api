@Library("my-shared-library") _

def salaryCI = new org.avengers.template.salary.salaryCI()

node {
    
    def url = 'https://github.com/OT-MICROSERVICES/salary-api.git'
    def branch = 'main'
    
    salaryCI.call(branch: branch,url: url)
    
}
