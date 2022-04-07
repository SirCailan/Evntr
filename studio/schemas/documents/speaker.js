export default {
    title: 'Speaker',
    name: 'speaker',
    type: 'document',
    fields: [
        {
            title: 'Name',
            name: 'name',
            type: 'string',
            description: 'Please use "Firstname Lastname" format',
        },
        {
            title: 'Image',
            name: 'image',
            type: 'image',
            fields: [
                {
                    title: 'Caption',
                    name: 'caption',
                    type: 'text',
                    options: {
                        isHighlighted: true
                    }
                }
            ],
            options: {
                hotspot: true,
            }
        }
    ]
}