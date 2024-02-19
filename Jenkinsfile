@Library("my-shared-library") _

def salaryCI = new org.avengers.template.salary.salaryCI()

node {
    
    def url = 'https://github.com/CodeOps-Hub/Salary-API.git'
    def branch = 'feature/slarayCI'
    
    salaryCI.call(branch: branch,url: url)
    
}
