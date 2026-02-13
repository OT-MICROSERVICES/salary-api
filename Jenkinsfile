@Library('cicd') _
def cipipeline = new opstree.ci.templates.artifact_management.artifact_management()

node {

  cipipeline.call([

    enable_jenkins_build_param_override: true,

    // ===================================================
    // WORKSPACE MANAGEMENT
    // ===================================================
    clean_workspace: true,
    ignore_clean_workspace_failure: true,
    delete_dirs: false,
    clean_when_build_aborted: true,
    clean_when_build_failed: true,
    clean_when_not_built: true,
    clean_when_build_succeed: true,
    clean_when_build_unstable: true,

    // ===================================================
    // VCS MANAGEMENT
    // ===================================================
    repo_https_url: "https://github.com/ayush090909/salary-api.git",
    repo_ssh_url: "https://github.com/ayush090909/salary-api.git",
    repo_branch: "main",
    repo_url_type: "http",
    jenkins_git_creds_id: "new-token",
    source_code_path: "",

    // ===================================================
    // SCANNING DISABLED FOR NOW
    // ===================================================
    dependency_check: false,
    gitleaks_check: false,
    perform_code_build: false,
    unit_testing_check: false,
    static_code_analysis_check: false,

    // ===================================================
    // DOCKER BUILD
    // ===================================================
    perform_build_dockerfile: true,
    image_name: "opstree",     // IMPORTANT — FIXED
    dockerfile_location: "/Dockerfile",
    dockerfile_context: "",
    source_code_path: "",
    codeartifact_dependency: false,
    codeartifact_domain: "",
    codeartifact_owner: "",

    // ===================================================
    // IMAGE TAGGING STRATEGY
    // ===================================================
    image_tagging_strategy: "timestamp",  // commit-hash | timestamp | build-number | metafile | custom | multi
    metafile_path: "",
    custom_image_tag: "",
    push_latest: true,
    keep_last_images: 10,

    // ===================================================
    // IMAGE SCANNING (DISABLED)
    // ===================================================
    image_scanning_check: false,
    image_tag: "latest",
    scan_severity: "CRITICAL",
    image_scanning_report_publish: false,

    // ===================================================
    // IMAGE SIZE VALIDATION
    // ===================================================
    image_size_validator_check: false,
    max_allowed_image_size: 100,
    fail_job_if_validation_fail: false,

    // ===================================================
    // ARTIFACT PUBLISH — ECR PUSH
    // ===================================================
    artifact_publish_check: true,
    artifact_destination_type: "ecr",
    jenkins_aws_credentials_id: "aws-creds",
    docker_image_name: "opstree",     // MUST MATCH build
    ecr_repo_name: "opstree",
    ecr_region: "us-east-1",
    account_id: "384961893048",

    // ===================================================
    // HARBOR (DISABLED)
    // ===================================================
    harbor_url: "",
    harbor_project: "",
    harbor_credentials_id: "",

    // ===================================================
    // DOCKERFILE LINTING (DISABLED)
    // ===================================================
    dockle_scan_check: false,
    dockle_report_publish: false,
    hadolint_scan_check: false,
    hadolint_report_publish: false,
    fail_job_on_hadolint_error: false,

    // ===================================================
    // JIRA DISABLED
    // ===================================================
    enable_jira: false,
    fail_job_if_jira_operation_failed: false,
    enable_buildlogurl_in_jiracomment: false,

    // ===================================================
    // TRIGGER PIPELINE DISABLED
    // ===================================================
    enable_trigger_cd_pipeline: false,

    // ===================================================
    // NOTIFICATIONS DISABLED
    // ===================================================
    notification_enabled: false,
    notification_channel: "teams",
    webhook_url_creds_id: "teams_webhook"

  ])
}
