export default {
    title: 'User',
    name: 'user',
    type: 'document',
    fields: [
        {
            title: 'Username',
            name: 'name',
            type: 'string'
        },
        {
            title: 'Email',
            name: 'email',
            type: 'string',
            validation: Rule => Rule.required(),
        },
        {
            title: 'Has liked these events',
            name: 'starred',
            type: 'array',
            of: [{
                type: 'reference',
                to: [{
                    type: 'event'
                }]
            }]
        }
    ]
}